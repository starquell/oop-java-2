import React from "react";
//import * as API from  "API.js"
/* We simply can use an array and loop and print each user */
import {Redirect} from 'react-router-dom'
import NavBar from "../../components/nav-bar";
import styles from "../../styles/General.module.css"
import * as API from "../../services/API";
import general from "../../styles/General.module.css";
import smallList from "../../styles/SmallList.module.css";

export class GeneralDevelopings extends React.Component{

    constructor(props) {
        super(props);
        this.state = {}
    }

    componentDidMount = () => {
        this.GetDevelopings().then((developings) => {
            this.setState({
                developings : developings,
                counted: true
            })
        }).catch((error) => {
            console.log(error);
        });

    }

    async GetTasks() {
        return await API.getTasks()
    }

    async GetEmployees() {
        return await API.getEmployees()
    }

    async GetDevelopings() {
        return await API.getDevelopings()
    }

    makeDevelopingsList(){
        return (<ul className={general.listOfCards}>
            {
                this.state.developings.map((dev) => <li className={general.listElement}>
            <div className={general.listCard}><div className={smallList.smallP}>{"".concat("Task: ", dev["task_id"], ", assignee: ", dev["employee_id"], ", estimation: ", dev["hrs"], ", ", dev["active"] ? "active!" : "inactive")}</div></div></li>)}</ul>);

    }

    render() {
        if(this.state !== undefined && this.state.counted){
            let list = this.makeDevelopingsList()
            return (
                <div>
                    <NavBar fatherlink={'/'}/>
                    <div className={general.MainBodyContainer}>
                        {list}
                    </div>
                </div>
            );
        } else {
            return (
                <div>
                    <NavBar fatherlink={'/'}/>
                    <div className={general.MainBodyContainer}>
                        <div>No developings here</div>
                    </div>
                </div>
            );
        }

    }
}
