import React from 'react';
import {MdDelete, MdModeEdit} from 'react-icons/md';

import api from '../../services/api';
import './styles.css';


function Administrador() {
    const [users, setUsers] = React.useState([]);

    const getUsers = async () => {
        const response =  await api.get(`users/getAll`);
        setUsers(response.data);
    }

    const deleteUser = async ( idUser ) => {
        await api.delete(`users/delete/` + idUser);

        window.location.reload(false);
    }    
    
    const EditUser = ( idUser ) => {
        window.location.href = `/administrador/cadastro/${idUser}`;
    }

    const insertUser = ( ) => {
        window.location.href = `/administrador/cadastro/0`;
    }

    React.useEffect(() => {
        getUsers();
    }, []);

    return (
        <div id="box-container">
            <header>
                <h1>Cadastro de usuários</h1>
            </header>

            <ul>
                <li>
                    <h3>Usuário</h3>
                    <button onClick={() => insertUser()}>Incluir</button>
                </li>
                
                {users.map(user => (
                    <li key={user.iduser}>
                        <h5 id="dados">{user.username}</h5>
                        <div id="buttons">
                            <MdModeEdit onClick={() => EditUser(user.iduser)} size={24} color="#3255a5" />
                            <MdDelete onClick={() => deleteUser(user.iduser)} size={24} color="#3255a5"/>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Administrador;
