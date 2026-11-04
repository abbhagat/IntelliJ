import React, {useState} from 'react';

export function HookCounter2() {

    const initialVal = 0;

    const [count, setCount] = useState(initialVal);

    const incrementFive = () => {
        for (let i = 0; i < 5; i++) {
            setCount(prevCount => prevCount + 1);
        }
    }

    return (
        <div>
            Count = {count}
            <button onClick={() => setCount(initialVal)}>Reset</button>
            {/*<button onClick={() => setCount(count + 1)}>Incr</button>*/}
            {/*<button onClick={() => setCount(count - 1)}>Decr</button>*/}
            <button onClick={() => setCount(prevCount => prevCount + 1)}>Incr</button>
            <button onClick={() => setCount(prevCount => prevCount - 1)}>Decr</button>
            <button onClick={incrementFive}>Incr 5</button>
        </div>
    );
}