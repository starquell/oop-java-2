import React from "react";
import * as API from "../../services/API.js"
import generalStyles from "../../styles/General.module.css"
import styles from "../../styles/Tasks.module.css"
import Checkbox from "../../components/additional-components/Checkbox";
import {Link} from 'react-router-dom'
import NavBar from "../../components/nav-bar";
import general from "../../styles/General.module.css";
import smallList from "../../styles/SmallList.module.css";


const routeTypes = [
    'Тролейбус',
    'Автобус',
    'Трамвай',
];

export class Tasks extends React.Component{

    constructor(props) {
        super(props);
        this.state = {}
    }

    componentDidMount = () => {
        this.GetTasks().then((tasks) => {
            this.setState({
                tasks : tasks,
                counted: true
            })
        }).catch((error) => {
            console.log(error);
        });
    }

    async GetTasks() {
        return await API.getTasks()
    }

    makeTasksList(){
        return (<ul className={general.listOfCards}>
            {
                this.state.tasks.map((task) => <li key={task["id"]} className={general.listElement}>
            <div className={general.listCard}><div className={smallList.smallP}>{task["name"]}</div></div></li>)}</ul>);
    }

    render() {
        if(this.state !== undefined && this.state.counted){
            let list = this.makeTasksList()
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
                        <div>No employees here</div>
                    </div>
                </div>
            );
        }

    }
}

export default Tasks;