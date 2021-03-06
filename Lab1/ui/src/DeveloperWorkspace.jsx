import { Component } from "react";
import Greeting from "./Greeting.jsx";
import $, { post } from "jquery";

class DeveloperWorkspace extends Component{
    constructor(props){
        super(props);
        this.state = {
            task_id: 0,
            hrs: 0,
            show_input: false
        };
        this.componentDidMount = this.componentDidMount.bind(this);
        this.onHandleChange = this.onHandleChange.bind(this);
        //this.getTasks = this.getTasks.bind(this);
        this.render = this.render.bind(this);
    }

    componentDidMount(){
        $.post({
            url: 'http://localhost:8088/lab1/index',
            contentType: "application/json",
            data: JSON.stringify({
                action: 'getlist',
                employee_id: localStorage.getItem("employee_id")
            }),
            crossDomain: true,
            xhrFields: { withCredentials: true },
            success: function(responseJSON){
                let select=$('#tasks');
                $.each(responseJSON, function(index, item) { // Iterate over the JSON array
                    select.append('<option value="'+item.id+'">'+item.name+'</option>');
                }.bind(this));
            }.bind(this),
        });

        $(document).on("change", "#tasks", function(event){
            const new_task = $('#tasks').find(":selected").val();
            this.setState({
                show_input: true,
                task_id: new_task
            })
            $.post({
                url:'http://localhost:8088/lab1/index',
                contentType: "application/json",
                data: JSON.stringify({
                    action: 'get',
                    employee_id: localStorage.getItem("employee_id"),
                    task_id: this.state.task_id
                }),
                crossDomain: true,
                xhrFields: { withCredentials: true },
                success: function(response){
                    const hours = parseInt(response);
                    this.setState({
                        hrs: hours
                    })
                }.bind(this),
            });
            $("#hours").css('visibility', 'visible');
        }.bind(this));

        $(document).on("click", "#savebtn", function(event){
            $.post({
                url: 'http://localhost:8088/lab1/index',
                contentType: "application/json",
                data: JSON.stringify({
                    action: 'save',
                    employee_id: localStorage.getItem("employee_id"),
                    task_id: this.state.task_id,
                    hrs: this.state.hrs 
                }), 
                crossDomain: true,
                xhrFields: { withCredentials: true },                  
            });
        }.bind(this));
    }

    onHandleChange(e){
        this.setState({
          hrs: e.target.value
        });
    }
    
    render(){
 /*        const items = [];
        for (const [index, value] of this.state.tasks.entries()) {
            items.push(this.renderOption(index, value));
        }  */  
        return(
            <div>
                <Greeting />
                <table class = "grid">
                    <tr>
                        <td class = "gridline labelcol">Task:</td>
                        <td class = "gridline inputcol">
                        <select name = "tasks" id = "tasks">
                            { !this.state.show_input ? <option name="tasks" value='0' id="none">Choose task</option> : null}
                        </select>
                        </td>
                    </tr>
                    { this.state.show_input ? <tr>                       
                        <td class = "gridline labelcol">Spent hours:</td>
                        <td class = "gridline inputcol">
                            <input 
                                type = "number" 
                                id = "hours" 
                                value = {this.state.hrs} 
                                min = '0' 
                                step = '1'  
                                onChange={this.onHandleChange}
                            />
                        </td>
                    </tr> : null}
                    <tr>
                        <td colSpan='2'>
                            <center><button id = "savebtn">Save</button></center>
                        </td> 
                    </tr>
                </table>
                
            </div>
        )
    }
}

export default DeveloperWorkspace;