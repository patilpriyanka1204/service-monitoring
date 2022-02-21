import React, { Component } from "react";
import {BrowserRouter as Router, Route,Link, Switch} from 'react-router-dom'
import "bootstrap/dist/css/bootstrap.min.css";
import CreateServiceComponent from "./component/CreateServiceComponent";
import MonitorServiceComponent from "./component/MonitorServiceComponent";
class App extends Component {
  render() {
      return (
        <div>
            <div>
              <CreateServiceComponent />
            </div>
            <div>
              <MonitorServiceComponent />
            </div>
        </div>
        
      );
      // ...
    }
}
export default App;
