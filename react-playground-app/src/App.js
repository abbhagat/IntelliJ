import './App.css';
import Counter from "./components/Counter";
import {HookCounter} from "./components/HookCounter";
import {HookCounter2} from "./components/HookCounter2";
import {HookCounter3} from "./components/HookCounter3";
import {HookCounter4} from "./components/HookCounter4";
import {HookCounter5} from "./components/HookCounter5";
import {HookMouse} from "./components/HookMouse";
import IntervalHookCounter from "./components/IntervalHookCounter";
import {DataFetching} from "./components/DataFetching";
import {SingleDataFetching} from "./components/SingleDataFetching";

function App() {
    return (
        <div className="App">
            {/*<Counter/>*/}
            {/*<HookCounter/>*/}
            {/*<HookCounter2/>*/}
            {/*<HookCounter3/>*/}
            {/*<HookCounter4/>*/}
            {/*<HookCounter5/>*/}
            {/*<HookMouse/>*/}
            {/*<IntervalHookCounter/>*/}
            {/*<DataFetching/>*/}
            <SingleDataFetching/>
        </div>
    );
}

export default App;
