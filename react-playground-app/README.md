# Employee management app

React employee directory built with Material UI, MUI X Data Grid, and SheetJS.

## Run locally

```bash
npm install
npm start
```

Open the local URL printed by Create React App (normally http://localhost:3000).

## Build

```bash
npm run build
```

The app starts with realistic in-memory sample employees. Search filters, pagination, sorting, employee add/edit/delete, and Excel export work in the browser. Data resets when the page is refreshed.

### Connect a REST API

In `src/App.js`, replace the local list/filter and mutation code with calls to your service:

- Load/filter: `GET /api/employees` (pass the applied search filters as query parameters).
- Create: `POST /api/employees`.
- Update: `PUT /api/employees/:id`.
- Delete: `DELETE /api/employees/:id`.

The relevant replacement points are marked inline next to the local state handlers. Keep the API record shape aligned with the employee fields used by the grid.
