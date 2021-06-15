import * as PureAPI from "./PureAPI";

let backUrl = 'http://localhost:8080/api/'


export async function getDevelopings() {
    return await PureAPI.sendGetRequest(backUrl + 'developings')
}

export async function getTasks() {
    return await PureAPI.sendGetRequest(backUrl + 'tasks')
}

export async function getEmployees() {
    return await PureAPI.sendGetRequest(backUrl + 'employees')
}

export async function getEmployee(id) {
    return await PureAPI.sendGetRequest(backUrl + 'employees/' + id)
}

export function createEmployee(state){
    return PureAPI.sendPostRequest(backUrl + 'employees', employeeToJson(state))
}

export async function updateEmployee(state){
    return await PureAPI.sendPutRequest(backUrl + 'employees/' + state.id, employeeToJson(state))
}

export function deleteEmployee(id){
    return PureAPI.sendDeleteRequest(backUrl + 'employees/' + id)
}

function employeeToJson(state) {
    return JSON.stringify({
        "id": state.id,
        "name": state.name
    })
}

