import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

import Login from './pages/Login';
import Administrador from './pages/Administrador';
import CadastroAdministrador from './pages/Administrador/cadastro.js';
import Triador from './pages/Triador';
import CadastroTriador from './pages/Triador/cadastro.js';
import Finalizador from './pages/Finalizador';
import CadastroFinalizador from './pages/Finalizador/cadastro.js';

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path="/" exact component={Login}/>
            <Route path="/administrador" exact component={Administrador}/>
            <Route path="/administrador/cadastro/:id" exact component={CadastroAdministrador}/>
            <Route path="/triador" exact component={Triador}/>
            <Route path="/triador/cadastro" exact component={CadastroTriador}/>
            <Route path="/finalizador/:id" exact component={Finalizador}/>
            <Route path="/finalizador/cadastro/:id" exact component={CadastroFinalizador}/>
        </Switch>
    </BrowserRouter>
);

export default Routes;