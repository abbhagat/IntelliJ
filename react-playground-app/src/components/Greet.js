import React from "react";

// function Greet({ name }) {
//   return <h1>Hello, {name}!</h1>;
// }
// export default Greet;  // You can import this Component with any name you want, because it is a default export

export const Greet = (props) => {  // Named Export
  const {name, empId} = props;
  // console.log(props.name)
  return (
    <div>
      <h1>Hello, {props.name}! Your empId is {props.empId}</h1>
      <h1>Hello, {name}! Your empId is {empId}</h1>
      <h3>{props.children}</h3>
    </div>
  );
}
