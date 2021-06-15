import React from "react";
import {Redirect} from "react-router-dom";
import * as API from "../services/API";
import { withRouter } from 'react-router-dom';
import TimeTableForm from "../components/additional-components/TimeTableForm";
import NavBar from "../components/nav-bar";
import Loading from "../components/loading";
import styles from "../styles/General.module.css"



export class EmployeeObject extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            counted: false
        }
    }
    componentDidMount = () => {
        let number = this.getEmployeeId(window.location.href)
        console.log("Employee number " + number)
        this.GetEmployee(number).then((employee) => {
            if (employee === undefined){
                this.setState({
                    incorrectRoute: true,
                    counted: true
                })
            } else {
                let routeId = employee.routeId
                console.log("Route id " + routeId)
                this.setState({
                    id: employee.id,
                    name: employee.name,
                    login: employee.login,
                    counted : true
                })
            }

        }).catch((error) => {
            console.log(error);
        });

    }

    async GetEmployee(number) {
        return await API.getEmployee(number)
    }

    getEmployeeId(url){
        let id = url.lastIndexOf('=')
        let numberStr = url.substring(id + 1)
        return parseInt(numberStr)
    }

    render() {

        if (this.state === undefined || this.state.counted === false){
            return <Loading/>
        }

        if(this.state.incorrectRoute){
            return (
                <div>
                    <h1>Employee not found.</h1>
                </div>
            )
        }

        return (
            <div>
                <NavBar fatherlink={'/employees'}/>
                <div className={styles.MainBodyContainer}>
                    <p>Name:  {this.state.name}</p>
                    <p>Login: {this.state.login}</p>
                </div>

            </div>
        )


    }


}