import React from 'react'
import { Navigate } from 'react-router-dom'
import Navbar from '../components/Navbar'
import { IAdmin } from '../models/IAdmin'

function Control( props: {item: JSX.Element} ) {
  
  const stSession = sessionStorage.getItem('admin')
  var admin:IAdmin
  if ( stSession !== null ) {
    admin = JSON.parse(stSession) as IAdmin
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