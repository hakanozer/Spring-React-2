import React, { useState } from 'react'
import Navbar from '../components/Navbar'

function Home() {

   const [name, setName] = useState('')
   const [email, setEmail] = useState('')
   const [password, setPassword] = useState('')

  // send form
  const sendForm = (evt:React.FormEvent) => {
    evt.preventDefault()
    console.log(name,email,password)
  }

  // arr
  const arr = ["İstanbul", "Ankara", "İzmir", "Samsun", "Gaziantep"]
  const products = [
    { title: 'TV', price: 25000, detail: 'TV Detay' },
    { title: 'iPhone', price: 55000, detail: 'iPhone Detay' },
    { title: 'Bilgisayar', price: 33000, detail: 'Bilgisayar Detay' },
    { title: 'Termos', price: 400, detail: 'Termos Detay' },
  ]

  return (
    <>
        <Navbar />
        <h2>User Register</h2>
        <form onSubmit={sendForm} className='col-sm-5'>
            <div className="mb-3">
                <input onChange={(evt) => setName(evt.target.value)} className='form-control' placeholder='Name' />
            </div>
            <div className="mb-3">
                <input onChange={(evt) => setEmail(evt.target.value)}  className='form-control' placeholder='E-Mail' />
            </div>
            <div className="mb-3">
                <input onChange={(evt) => setPassword(evt.target.value)}  className='form-control' type='password' placeholder='Password' />
            </div>
            <button className='btn btn-danger'>Send</button>
        </form>
        <hr></hr>
        {arr.map( (item, index) =>
            <li key={index}> {item} </li>
        )}
        <hr></hr>
        <div className='row'>
            {products.map((item, index) =>
                <div className='col-sm-4' key={index}>
                    <div>{item.title}</div>
                    <div>{item.price}</div>
                    <div>{item.detail}</div>
                    <br></br>
                </div>
            )}
        </div>
    </>
  )
}

export default Home