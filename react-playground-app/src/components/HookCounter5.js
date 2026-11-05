import React, {useEffect} from 'react';

export const HookCounter5 = () => {

    const [count, setCount] = React.useState(0);
    const [name, setName] = React.useState('');

    useEffect(() => {
        document.title = `You clicked ${count} times`;
    }, [count]);

    return (
        <div>
            <input type="text" value={name} onChange={e => setName(e.target.value)}/>
            <button onClick={() => setCount(count + 1)}>Count {count}</button>
        </div>
    );
};
