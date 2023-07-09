import React from 'react'
import { NavLink } from 'react-router-dom'

function Navbar() {
  return (
    <>
        <NavLink to='/'>Home</NavLink> | 
        <NavLink to='/category'>Category</NavLink> | 
        <NavLink to='/settings'>Settings</NavLink>
    </>
  )
}

export default Navbar