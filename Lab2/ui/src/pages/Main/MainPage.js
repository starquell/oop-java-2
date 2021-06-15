import React from "react";
import generalStyles from "../../styles/General.module.css"
import {Link} from 'react-router-dom';
import NavBar from "../../components/nav-bar";
import RenderOnAuthenticated from "../../components/render-on-authentificated";

export class MainPage extends React.Component{

    constructor(props) {
        super(props);
    }

    componentDidMount = () => {}

    render() {
        let adminButton = RenderOnAuthenticated(<Link to={'/editor'}><button className={generalStyles.BigButton} > Page<br/> адміністратора</button></Link>)
        return (
                <div>
                    <NavBar fatherlink={''}/>
                    <div className={generalStyles.BigButtonContainer}>
                        <Link to={'/tasks'}><button className={generalStyles.BigButton}> Tasks</button></Link>
                        <Link to={'/timetables'}><button className={generalStyles.BigButton} > Developing processes</button></Link>
                        <Link to={'/employees'}><button className={generalStyles.BigButton} > Employees</button></Link>
                        {adminButton}
                    </div>
                </div>
            );
     //   }
    }
}