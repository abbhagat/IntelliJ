import React from "react";

export class Welcome extends React.Component {
  render() {
    const {name, empId} = this.props;
    return <h1>Welcome to {this.props.name}!</h1>;
  }
}
