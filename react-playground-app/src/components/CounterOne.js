import React from 'react';

const initialState = 0;

const reducer = (count, action) => {
    switch (action) {
        case 'increment':
            return count + 1;
        case 'decrement':
            return count - 1;
        case 'reset':
            return initialState;
        default:
            return count;
    }
}

export const CounterOne = () => {

    const [count, dispatch] = React.useReducer(reducer, initialState);

    return (
        <div>
            <h2>Count: {count}</h2>
            <button onClick={() => dispatch('increment')}>Increment</button>
            <button onClick={() => dispatch('decrement')}>Decrement</button>
            <button onClick={() => dispatch('reset')}>Reset</button>
        </div>
    );
};