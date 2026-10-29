import './App.css';
import Greet from "./components/Greet";
import {Welcome} from "./components/Welcome";

function App() {
  return (
    <div className="App">
        <Greet name="Abhinaw" empId="V705417">
            <p>Your Employer is JP Morgan</p>
        </Greet>
        <Greet name="Abhinaw" empId="V705417">
            <button>Button</button>
        </Greet>
        <Welcome name="React"/>
    </div>
  );
}

export default App;
