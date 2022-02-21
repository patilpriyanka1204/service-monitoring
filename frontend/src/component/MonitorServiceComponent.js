import React, { Component } from 'react'
import UrlService from '../services/UrlService';

class MonitorServiceComponent extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            pollingList:[]
        }
    }

    componentDidMount(){
        UrlService.serviceMonitor().then((response) => {
            this.setState({ pollingList: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> Service List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> Name</td>
                            <td> URL</td>
                            <td> Status</td>
                            <td> Service Id</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.pollingList.map(
                                serivce => 
                                <tr key = {serivce.id}>
                                     <td> {serivce.name}</td>   
                                     <td> {serivce.url}</td>   
                                     <td> {serivce.status}</td>   
                                     <td> {serivce.id}</td>   
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}

export default MonitorServiceComponent;