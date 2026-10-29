import React from "react";

export class Welcome extends React.Component {
  render() {
    return <h1>Welcome to {this.props.name}!</h1>;
  }
}
