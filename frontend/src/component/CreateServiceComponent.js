import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import UrlService from '../services/UrlService';

class CreateServiceComponent extends React.Component {

    emptyService = {
        name:'',
        status:'',
        url:''
    }

    constructor(props){
        super(props)
        this.state = {
            service:this.emptyService
        };
    }

    componentDidMount(){
        UrlService.createService(this.state.service).then((response) => {
            this.setState({service : response.data})
        });
    }

    handleCreate() {
        this.props.history.push(`/services`)
        
    }

    render (){
        const {serv} = this.state.service;
        return (
            <div>
               <form onSubmit={this.handleCreate}>
                    <div className = "form-group">
                        <label> Name: </label>
                        <input type="text" name="name" id='name' className="form-control" 
                            />
                    </div>
                    <div className = "form-group">
                        <label> URL: </label>
                        <input type="text" name="url" id='url' className="form-control" 
                             />
                    </div>
                    <div className = "form-group">
                        <label> Status: </label>
                        <input type="text" name="status" id='status' className="form-control" 
                             />
                    </div>
                    <div className = "form-group">
                        <button color="primary" type="submit">Save</button>{' '}
                        <button color="secondary" tag={Link} to="/services">Cancel</button>
                    </div>
                   
               </form>

            </div>

        )
    }
}

export default CreateServiceComponent;