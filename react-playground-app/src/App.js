import { useMemo, useState } from 'react';
import {
  Alert, AppBar, Avatar, Box, Button, Chip, Container, Dialog, DialogActions,
  DialogContent, DialogTitle, IconButton, MenuItem, Paper, Snackbar, Stack,
  TextField, Toolbar, Tooltip, Typography,
} from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { DataGrid } from '@mui/x-data-grid';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import SearchRoundedIcon from '@mui/icons-material/SearchRounded';
import FileDownloadRoundedIcon from '@mui/icons-material/FileDownloadRounded';
import EditRoundedIcon from '@mui/icons-material/EditRounded';
import DeleteOutlineRoundedIcon from '@mui/icons-material/DeleteOutlineRounded';
import Groups2RoundedIcon from '@mui/icons-material/Groups2Rounded';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import { utils, writeFile } from 'xlsx';
import './App.css';

const theme = createTheme({
  palette: { primary: { main: '#4f46e5' }, background: { default: '#f6f7fb' }, text: { primary: '#172033', secondary: '#68738a' } },
  shape: { borderRadius: 12 }, typography: { fontFamily: 'Inter, ui-sans-serif, system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif', button: { textTransform: 'none', fontWeight: 650 } },
  components: { MuiButton: { styleOverrides: { root: { borderRadius: 9, boxShadow: 'none' } } }, MuiPaper: { styleOverrides: { root: { backgroundImage: 'none' } } } },
});

const seedEmployees = [
  { id: 'EMP-1042', name: 'Olivia Rhye', email: 'olivia.rhye@acme.com', department: 'Engineering', role: 'Senior Engineer', dob: '1992-04-16', salary: 128000, status: 'Active' },
  { id: 'EMP-1038', name: 'Phoenix Baker', email: 'phoenix.baker@acme.com', department: 'Design', role: 'Product Designer', dob: '1995-09-28', salary: 104000, status: 'Active' },
  { id: 'EMP-1035', name: 'Lana Steiner', email: 'lana.steiner@acme.com', department: 'People', role: 'HR Manager', dob: '1988-02-11', salary: 112000, status: 'Active' },
  { id: 'EMP-1031', name: 'Demi Wilkinson', email: 'demi.wilkinson@acme.com', department: 'Marketing', role: 'Growth Lead', dob: '1990-11-03', salary: 119500, status: 'Active' },
  { id: 'EMP-1027', name: 'Candice Wu', email: 'candice.wu@acme.com', department: 'Finance', role: 'Financial Analyst', dob: '1994-06-22', salary: 96500, status: 'Active' },
  { id: 'EMP-1024', name: 'Natali Craig', email: 'natali.craig@acme.com', department: 'Engineering', role: 'Frontend Engineer', dob: '1997-01-14', salary: 108000, status: 'On leave' },
  { id: 'EMP-1019', name: 'Drew Cano', email: 'drew.cano@acme.com', department: 'Sales', role: 'Account Executive', dob: '1989-08-09', salary: 101000, status: 'Active' },
  { id: 'EMP-1014', name: 'Orlando Diggs', email: 'orlando.diggs@acme.com', department: 'Engineering', role: 'Platform Engineer', dob: '1991-12-01', salary: 132000, status: 'Active' },
  { id: 'EMP-1008', name: 'Andi Lane', email: 'andi.lane@acme.com', department: 'Customer success', role: 'Customer Success Lead', dob: '1987-03-18', salary: 99000, status: 'Active' },
  { id: 'EMP-1003', name: 'Kate Morrison', email: 'kate.morrison@acme.com', department: 'Design', role: 'UX Researcher', dob: '1993-07-30', salary: 106000, status: 'On leave' },
];
const emptyFilters = { id: '', name: '', dob: '', salaryMin: '', salaryMax: '', ageMin: '', ageMax: '' };
const blankEmployee = { id: '', name: '', email: '', department: '', role: '', dob: '', salary: '', status: 'Active' };
const calculateAge = (dob) => {
  if (!dob) return '';
  const birth = new Date(`${dob}T00:00:00`);
  const today = new Date();
  return today.getFullYear() - birth.getFullYear() - ((today.getMonth() < birth.getMonth() || (today.getMonth() === birth.getMonth() && today.getDate() < birth.getDate())) ? 1 : 0);
};
const currency = new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD', maximumFractionDigits: 0 });

function App() {
  const [employees, setEmployees] = useState(seedEmployees);
  const [filters, setFilters] = useState(emptyFilters);
  const [activeFilters, setActiveFilters] = useState(emptyFilters);
  const [dialogOpen, setDialogOpen] = useState(false);
  const [editing, setEditing] = useState(null);
  const [form, setForm] = useState(blankEmployee);
  const [deleteTarget, setDeleteTarget] = useState(null);
  const [notice, setNotice] = useState('');

  // Replace this local filter with GET /api/employees?.... when connecting your REST service.
  const rows = useMemo(() => employees.filter((employee) => {
    const f = activeFilters;
    const age = calculateAge(employee.dob);
    return (!f.id || employee.id.toLowerCase().includes(f.id.trim().toLowerCase()))
      && (!f.name || employee.name.toLowerCase().includes(f.name.trim().toLowerCase()))
      && (!f.dob || employee.dob === f.dob)
      && (f.salaryMin === '' || employee.salary >= Number(f.salaryMin))
      && (f.salaryMax === '' || employee.salary <= Number(f.salaryMax))
      && (f.ageMin === '' || age >= Number(f.ageMin))
      && (f.ageMax === '' || age <= Number(f.ageMax));
  }), [employees, activeFilters]);

  const openAdd = () => { setEditing(null); setForm(blankEmployee); setDialogOpen(true); };
  const openEdit = (employee) => { setEditing(employee.id); setForm({ ...employee, salary: String(employee.salary) }); setDialogOpen(true); };
  const updateFilter = (key) => (event) => setFilters((previous) => ({ ...previous, [key]: event.target.value }));
  const handleSearch = (event) => { event.preventDefault(); setActiveFilters({ ...filters }); };
  const handleCancel = () => { setFilters(emptyFilters); setActiveFilters(emptyFilters); };
  const updateForm = (key) => (event) => setForm((previous) => ({ ...previous, [key]: event.target.value }));
  const saveEmployee = (event) => {
    event.preventDefault();
    const record = { ...form, salary: Number(form.salary) };
    if (!record.id.trim() || !record.name.trim() || !record.dob || !record.email.trim()) return;
    // Replace with POST /api/employees or PUT /api/employees/:id, then refresh the list.
    if (editing) setEmployees((current) => current.map((employee) => employee.id === editing ? record : employee));
    else setEmployees((current) => [{ ...record, id: record.id.trim() }, ...current]);
    setDialogOpen(false); setNotice(editing ? 'Employee updated' : 'Employee added');
  };
  const confirmDelete = () => {
    if (!deleteTarget) return;
    // Replace with DELETE /api/employees/:id, then refresh the list.
    setEmployees((current) => current.filter((employee) => employee.id !== deleteTarget.id));
    setDeleteTarget(null); setNotice('Employee deleted');
  };
  const exportExcel = () => {
    const data = rows.map((employee) => ({ 'Employee ID': employee.id, Name: employee.name, Email: employee.email, Department: employee.department, Role: employee.role, 'Date of birth': employee.dob, Age: calculateAge(employee.dob), 'Annual salary': employee.salary, Status: employee.status }));
    const worksheet = utils.json_to_sheet(data);
    worksheet['!cols'] = [{ wch: 16 }, { wch: 23 }, { wch: 31 }, { wch: 20 }, { wch: 25 }, { wch: 16 }, { wch: 10 }, { wch: 18 }, { wch: 14 }];
    const workbook = utils.book_new(); utils.book_append_sheet(workbook, worksheet, 'Employees');
    writeFile(workbook, `employees-${new Date().toISOString().slice(0, 10)}.xlsx`);
  };

  const columns = [
    { field: 'id', headerName: 'EMPLOYEE', minWidth: 125, flex: 0.85, renderCell: ({ row }) => <Stack direction="row" spacing={1.25} alignItems="center"><Avatar className="employee-avatar">{row.name.split(' ').map((part) => part[0]).slice(0, 2).join('')}</Avatar><Typography variant="body2" fontWeight={650}>{row.id}</Typography></Stack> },
    { field: 'name', headerName: 'NAME', minWidth: 205, flex: 1.3, renderCell: ({ row }) => <Box><Typography variant="body2" fontWeight={650}>{row.name}</Typography><Typography variant="caption" color="text.secondary">{row.email}</Typography></Box> },
    { field: 'department', headerName: 'DEPARTMENT', minWidth: 145, flex: 0.9 },
    { field: 'role', headerName: 'ROLE', minWidth: 170, flex: 1 },
    { field: 'dob', headerName: 'DOB · AGE', minWidth: 130, flex: 0.75, renderCell: ({ value }) => <Box><Typography variant="body2">{new Date(`${value}T00:00:00`).toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' })}</Typography><Typography variant="caption" color="text.secondary">{calculateAge(value)} years</Typography></Box> },
    { field: 'salary', headerName: 'SALARY', minWidth: 115, flex: 0.65, valueFormatter: (value) => currency.format(value) },
    { field: 'status', headerName: 'STATUS', minWidth: 110, flex: 0.6, renderCell: ({ value }) => <Chip size="small" label={value} className={value === 'Active' ? 'status-active' : 'status-leave'} /> },
    { field: 'actions', headerName: '', width: 94, sortable: false, filterable: false, disableColumnMenu: true, renderCell: ({ row }) => <Stack direction="row"><Tooltip title="Edit"><IconButton aria-label={`Edit ${row.name}`} size="small" onClick={() => openEdit(row)}><EditRoundedIcon fontSize="small" /></IconButton></Tooltip><Tooltip title="Delete"><IconButton aria-label={`Delete ${row.name}`} size="small" onClick={() => setDeleteTarget(row)}><DeleteOutlineRoundedIcon fontSize="small" /></IconButton></Tooltip></Stack> },
  ];

  return <ThemeProvider theme={theme}>
    <Box className="app-shell">
      <AppBar position="static" elevation={0} className="topbar"><Toolbar className="topbar-inner"><Stack direction="row" spacing={1.25} alignItems="center"><Box className="brand-mark"><Groups2RoundedIcon /></Box><Typography variant="subtitle1" fontWeight={750}>People<span className="brand-dot">.</span></Typography></Stack><Box sx={{ flex: 1 }} /><Avatar className="profile-avatar">JD</Avatar></Toolbar></AppBar>
      <Container maxWidth="xl" className="page-content">
        <Box className="page-heading"><Box><Typography variant="overline" className="eyebrow">PEOPLE OPERATIONS</Typography><Typography variant="h4" className="page-title">Employees</Typography><Typography color="text.secondary" variant="body2">Manage your people, all in one place.</Typography></Box><Button variant="contained" startIcon={<AddRoundedIcon />} onClick={openAdd}>Add employee</Button></Box>
        <Paper component="form" onSubmit={handleSearch} elevation={0} className="filter-card">
          <Box className="card-heading"><Box><Typography variant="subtitle1" fontWeight={700}>Find an employee</Typography><Typography variant="body2" color="text.secondary">Use one or more filters to narrow your list.</Typography></Box><SearchRoundedIcon className="search-heading-icon" /></Box>
          <Box className="filter-grid">
            <TextField label="Employee ID" placeholder="e.g. EMP-1042" value={filters.id} onChange={updateFilter('id')} size="small" />
            <TextField label="Name" placeholder="Search by name" value={filters.name} onChange={updateFilter('name')} size="small" />
            <TextField label="Date of birth" type="date" value={filters.dob} onChange={updateFilter('dob')} size="small" InputLabelProps={{ shrink: true }} />
            <TextField label="Salary from" type="number" placeholder="$0" value={filters.salaryMin} onChange={updateFilter('salaryMin')} size="small" inputProps={{ min: 0 }} />
            <TextField label="Salary to" type="number" placeholder="No limit" value={filters.salaryMax} onChange={updateFilter('salaryMax')} size="small" inputProps={{ min: 0 }} />
            <TextField label="Age from" type="number" placeholder="18" value={filters.ageMin} onChange={updateFilter('ageMin')} size="small" inputProps={{ min: 0 }} />
            <TextField label="Age to" type="number" placeholder="No limit" value={filters.ageMax} onChange={updateFilter('ageMax')} size="small" inputProps={{ min: 0 }} />
          </Box>
          <Stack direction="row" justifyContent="flex-end" spacing={1.25} className="filter-actions"><Button onClick={handleCancel} startIcon={<CloseRoundedIcon />}>Cancel</Button><Button type="submit" variant="contained" startIcon={<SearchRoundedIcon />}>Search</Button></Stack>
        </Paper>
        <Paper elevation={0} className="table-card">
          <Box className="table-heading"><Box><Stack direction="row" spacing={1.2} alignItems="center"><Typography variant="subtitle1" fontWeight={700}>All employees</Typography><Chip size="small" label={rows.length} className="count-chip" /></Stack><Typography variant="body2" color="text.secondary">A directory of everyone on your team.</Typography></Box><Button variant="outlined" startIcon={<FileDownloadRoundedIcon />} onClick={exportExcel}>Export Excel</Button></Box>
          <Box className="grid-wrap"><DataGrid rows={rows} columns={columns} getRowId={(row) => row.id} initialState={{ pagination: { paginationModel: { pageSize: 8, page: 0 } }, sorting: { sortModel: [{ field: 'name', sort: 'asc' }] } }} pageSizeOptions={[8, 15, 25]} disableRowSelectionOnClick autoHeight rowHeight={68} columnHeaderHeight={46} localeText={{ noRowsLabel: 'No employees match these filters.' }} /></Box>
        </Paper>
        <Typography className="footer-note" variant="caption">Showing {rows.length} of {employees.length} employees</Typography>
      </Container>
      <Dialog open={dialogOpen} onClose={() => setDialogOpen(false)} fullWidth maxWidth="sm"><Box component="form" onSubmit={saveEmployee}><DialogTitle>{editing ? 'Edit employee' : 'Add employee'}<Typography variant="body2" color="text.secondary" sx={{ mt: 0.5 }}>Enter the employee details below.</Typography></DialogTitle><DialogContent><Box className="dialog-grid">
        <TextField required label="Employee ID" value={form.id} onChange={updateForm('id')} disabled={Boolean(editing)} size="small" />
        <TextField required label="Full name" value={form.name} onChange={updateForm('name')} size="small" />
        <TextField required type="email" label="Work email" value={form.email} onChange={updateForm('email')} size="small" />
        <TextField label="Department" value={form.department} onChange={updateForm('department')} size="small" />
        <TextField label="Job title" value={form.role} onChange={updateForm('role')} size="small" />
        <TextField required type="date" label="Date of birth" value={form.dob} onChange={updateForm('dob')} size="small" InputLabelProps={{ shrink: true }} />
        <TextField required type="number" label="Annual salary (USD)" value={form.salary} onChange={updateForm('salary')} size="small" inputProps={{ min: 0 }} />
        <TextField select label="Status" value={form.status} onChange={updateForm('status')} size="small"><MenuItem value="Active">Active</MenuItem><MenuItem value="On leave">On leave</MenuItem></TextField>
      </Box></DialogContent><DialogActions sx={{ px: 3, pb: 2.5 }}><Button onClick={() => setDialogOpen(false)}>Cancel</Button><Button type="submit" variant="contained">{editing ? 'Save changes' : 'Add employee'}</Button></DialogActions></Box></Dialog>
      <Dialog open={Boolean(deleteTarget)} onClose={() => setDeleteTarget(null)}><DialogTitle>Delete employee?</DialogTitle><DialogContent><Typography color="text.secondary">This will remove {deleteTarget?.name} from the employee list. This action cannot be undone.</Typography></DialogContent><DialogActions sx={{ p: 2.5 }}><Button onClick={() => setDeleteTarget(null)}>Cancel</Button><Button color="error" variant="contained" onClick={confirmDelete}>Delete employee</Button></DialogActions></Dialog>
      <Snackbar open={Boolean(notice)} autoHideDuration={3000} onClose={() => setNotice('')} anchorOrigin={{ vertical: 'bottom', horizontal: 'right' }}><Alert onClose={() => setNotice('')} severity="success" variant="filled">{notice}</Alert></Snackbar>
    </Box>
  </ThemeProvider>;
}

export default App;
