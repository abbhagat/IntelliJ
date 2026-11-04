import './App.css';
import Counter from "./components/Counter";
import {HookCounter} from "./components/HookCounter";
import {HookCounter2} from "./components/HookCounter2";

function App() {
    return (
        <div className="App">
            <Counter/>
            <HookCounter/>
            <HookCounter2/>
        </div>
    );
}

export default App;
