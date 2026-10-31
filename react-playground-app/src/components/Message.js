import React from "react";

export class Message extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            message: "Welcome Visitor!"
        }
    }

    changeMessage() {
        this.setState({
            message: "Thank you for visiting!"
        })
    }

  render() {
    return (
        <div>
            <h1>{this.state.message}</h1>
            {/*<button id={"changeMessage"} onClick={() => this.setState({message: "Thank you for visiting!"})}>Change Message</button>*/}
            <button id={"changeMessage"} onClick={() => this.changeMessage()}>Change Message</button>
        </div>
    )
  }
}

export default Message;