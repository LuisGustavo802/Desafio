import React, { Component } from 'react';
import Select from 'react-select';

import api from '../../services/api';
import './styles.css';

export default class Main extends Component {
    state = {
        user: [],
        username: '',
        password: '',
        accesslevel: ''
    }
    

    handleInputUserChange = e => {
        this.setState({ username: e.target.value });
    }

    handleInputPasswordChange = e => {
        this.setState({ password: e.target.value });
    }
    
    handleInputSelectChange = e => {
      this.setState({ accesslevel: e.value });
    }

    handleSubmit = async e => {
        e.preventDefault();

        const user = this.props.match.params.id;

        if ( user > 0 ){
          await api.post("users/update", {
            iduser: user,
            username: this.state.username,
            password: this.state.password,
            accesslevel: this.state.accesslevel,
          });          
        } else {
          await api.post("users/insert", {
            username: this.state.username,
            password: this.state.password,
            accesslevel: this.state.accesslevel,
          });
        }

        this.props.history.push(`/administrador`);
    }

    async componentDidMount() {
  
      const user = this.props.match.params.id;

      if ( user > 0 ){
        const response = await api.get(`users/getById/${user}`);
        this.setState({ user: response.data });
      }
    }    

    render() {
      const options = [
        { value: 'A', label: 'Administrador' },
        { value: 'T', label: 'Triador' },
        { value: 'F', label: 'Finalizador' }
      ];

      return (
          <div id="main-container">
              <form onSubmit={this.handleSubmit}>
                  <input 
                      placeholder="Username"
                      value={this.state.user.username}
                      onChange={this.handleInputUserChange}
                  /> 
                  <input 
                      placeholder="Senha"
                      value={this.state.user.password}
                      onChange={this.handleInputPasswordChange}
                  />
                  <Select 
                    id="select"
                    placeholder="Nível de acesso"
                    onChange={this.handleInputSelectChange}
                    value={options.find(obj => obj.value === this.state.user.accesslevel)}
                    options={options} 
                  />

                  <button type="submit">Gravar</button>
              </form>
          </div>
    );
  }
}