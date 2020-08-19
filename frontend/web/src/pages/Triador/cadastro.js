import React, { Component } from 'react';
import Select from 'react-select';

import api from '../../services/api';
import './styles.css';

export default class Main extends Component {
    state = {
        description: '',
        users: []
    }
    
    handleInputDescricaoChange = e => {
      this.setState({ description: e.target.value });
  }

  handleInputUsersChange = e => {
    this.state.users = e;
  }

    handleSubmit = async e => {
        e.preventDefault();

        const response = await api.post("process/insert", {
          description: this.state.description
        });

        let i, user, process;

        process = response.data;

        for (i = 0; i < this.state.users.length; i++) {
          user = this.state.users[i].value;

          const response = await api.post("feedbackprocess/insert", {
            idprocess: process,
            iduser: user,
            feedback: "",
            fgrevised: "F",
          });
        }
        
        this.props.history.push(`/triador`);
    }   

    async componentDidMount() {
      const response = await api.get(`users/getAllFinalizadores`);
      this.setState({ users: response.data });
    }        

    render() {
      return (
          <div id="main-container">
              <form onSubmit={this.handleSubmit}>
                  <input 
                      placeholder="Descrição"
                      value={this.state.description}
                      onChange={this.handleInputDescricaoChange}
                  />

                  <Select
                    isMulti
                    name="colors"
                    options={this.state.users}
                    placeholder="Selecione os usuários"
                    onChange={this.handleInputUsersChange}
                    id="select"
                  />
                  <button type="submit">Gravar</button>
              </form>
          </div>
    );
  }
}