import React from 'react'
import { Navigate, useNavigate } from 'react-router-dom'
import Navbar from '../components/Navbar'
import { IAdmin } from '../models/IAdmin'
import { decrypt } from '../util'

function Control( props: {item: JSX.Element} ) {
  
  const navigate = useNavigate()
  const stSession = sessionStorage.getItem('admin')
  var admin:IAdmin
  if ( stSession !== null ) {
    try {
      const plainText = decrypt(stSession)
      admin = JSON.parse(plainText) as IAdmin
    } catch (error) {
      sessionStorage.removeItem('admin')
      navigate('/')
    }
  }
    
  return (
    <>
     { stSession === null 
     ?
     <Navigate to='/' replace />
     :
     <>
        <Navbar admin={admin!} />
        {props.item}
     </>
     }
    </>
  )
}

export default Control