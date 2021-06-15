import React, { Component } from "react";
//Import all needed Component for this tutorial
import {
    BrowserRouter as Router,
    Route,
    Switch,
    Link,
    Redirect
} from "react-router-dom";

//Pages
import {MainPage} from "./pages/Main/MainPage.js";
import Tasks from "./pages/Tasks/Tasks.js";
import {GeneralDevelopings} from "./pages/Developings/Developings";
import {GeneralEmployees} from "./pages/Employees/Employees";
import { useAuth0 } from "@auth0/auth0-react";
import { NavBar, Footer, Loading } from "./components";
import {EmployeeObject} from "./models/EmployeeObject";

import styles from "./styles/General.module.css";

const App = () => {
    const { isLoading } = useAuth0();

    if (isLoading) {
        return <Loading />;
    }

    return (
        <div id="app" className={styles.MainApp}>
                <Switch>
                    <Route exact path="/" component={MainPage} />
                    <Route exact path="/tasks" component={Tasks} />
                    <Route path="/timetables" component={GeneralDevelopings} />
                    <Route path="/employees" component={GeneralEmployees} />
                    <Route path="/employee" component={EmployeeObject} />
                </Switch>
        </div>
    );
};

export default App;

///< index.jsx will be automatically imported
//And render that route with the MainPage component for the root path /
/*
class App extends Component {
    render() {
        return (
            <Router>

            </Router>
        );
    }
}

export default App;*/