import React from "react";

// function Greet({ name }) {
//   return <h1>Hello, {name}!</h1>;
// }

// Named Export -> export const Greet = ({ name }) => <h1>Hello, {name}!</h1>;
const Greet = (props) => {
    console.log(props.name)
    return <div>
        <h1>Hello, {props.name}! Your empId is {props.empId}</h1>
        <h3>{props.children}</h3>
    </div>
}

export default Greet;