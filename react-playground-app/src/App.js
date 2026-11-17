import './App.css';
import {CounterTwo} from "./components/CounterTwo";
import {Welcome} from "./components/Welcome";
import {Greet} from "./components/Greet";

function App() {
  return (
    <div className="App">
      <Greet name="John" empId="12345">
        <p>Welcome to React Tutorial</p>
      </Greet>
      <Welcome name="John" empId="12345"/>
      {/*<Counter/>*/}
      {/*<HookCounter/>*/}
      {/*<HookCounter2/>*/}
      {/*<HookCounter3/>*/}
      {/*<HookCounter4/>*/}
      {/*<HookCounter5/>*/}
      {/*<HookMouse/>*/}
      {/*<IntervalHookCounter/>*/}
      {/*<DataFetching/>*/}
      {/*<SingleDataFetching/>*/}
      {/*<CounterOne/>*/}
      <CounterTwo/>
    </div>
  );
}

export default App;
