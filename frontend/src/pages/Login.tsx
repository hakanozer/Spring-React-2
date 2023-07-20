import React, { FormEvent, useState } from 'react'
import { login } from '../service'
import { useNavigate } from 'react-router-dom'
import { encrypt } from '../util'

function Login() {

  const navigate = useNavigate()

  const [username, setUsername] = useState('kminchelle')
  const [password, setPassword] = useState('0lelplR')
  const sendForm = (evt: FormEvent) => {
    evt.preventDefault()
    login(username, password).then( res => {
        const stData = JSON.stringify(res.data)
        const cipherText = encrypt(stData)
        sessionStorage.setItem('admin', cipherText)
        navigate('/home')
    }).catch(err => {
        console.log(err.message)
        alert("Username or Password Fail")
    })
  }

  return (
    <div className='row'>
        <div className='col-sm-4'></div>
        <div className='col-sm-4'>
            <h2>Admin Login</h2>
            <form onSubmit={sendForm}>
                <div className='mb-3'>
                    <input value={username} required onChange={(evt) => setUsername(evt.target.value)} className='form-control' placeholder='Username' />
                </div>
                <div className='mb-3'>
                    <input value={password} required type='password' onChange={(evt) => setPassword(evt.target.value)} className='form-control' placeholder='Password' />
                </div>
                <button className='btn btn-success'>Send</button>
            </form>
        </div>
        <div className='col-sm-4'></div>
    </div>
  )
}

export default Login