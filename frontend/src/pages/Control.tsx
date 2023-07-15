import React from 'react'
import { Navigate } from 'react-router-dom'
import Navbar from '../components/Navbar'

function Control( props: {item: JSX.Element} ) {
  
  const stSession = sessionStorage.getItem('admin')
    
  return (
    <>
     { stSession === null 
     ?
     <Navigate to='/' replace />
     :
     <>
        <Navbar />
        {props.item}
     </>
     }
    </>
  )
}

export default Control