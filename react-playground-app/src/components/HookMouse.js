import React, {useState, useEffect} from 'react';

export const HookMouse = () => {

    const [x, setX] = useState(100);
    const [y, setY] = useState(500);

    const logMousePosition = (event) => {
        console.log('Mouse event');
        setX(event.clientX);
        setY(event.clientY);
    }

    useEffect(() => {
        console.log('useEffect called');
        window.addEventListener('mousemove', logMousePosition);
        return () => {
            console.log('Component unmounting code');
            window.removeEventListener('mousemove', logMousePosition);
        }
    }, []);

    return (
        <div>
            Hooks X - {x} Y - {y}
        </div>
    );
};
