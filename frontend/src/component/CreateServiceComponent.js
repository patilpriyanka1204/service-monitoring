import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import UrlService from '../services/UrlService';

class CreateServiceComponent extends React.Component {


    constructor(props){
        super(props)
        this.state = {name: "",
                    url:""
        };
        this.handleCreate=this.handleCreate.bind(this);
    }


    handleCreate(e) {
        e.preventDefault()
        UrlService.createService({
            "name" : this.state.name,
            "url" : this.state.url
            
        }).then(response =>{console.log(response)}).catch(error => {
            console.log(error)
        })
        
    }

    handleNameInput(e) {
        this.setState({name:e.target.value})
    }

    handleUrlInput(e) {
        this.setState({url:e.target.value})

    }

    render (){
        return (
            <div>
               <form onSubmit={this.handleCreate}>
                    <div className = "form-group">
                        <label> Name: </label>
                        <input type="text" name="name" id='name' className="form-control" onChange={e => this.handleNameInput(e)} 
                            />
                    </div>
                    <div className = "form-group">
                        <label> URL: </label>
                        <input type="text" name="url" id='url' className="form-control" onChange={e => this.handleUrlInput(e)}
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