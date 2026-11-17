import React, {Component} from "react";

export class Welcome extends Component {

  render() {
    const {name, empId} = this.props;
    return <h1>Welcome to {this.props.name}!</h1>;
  }

}
