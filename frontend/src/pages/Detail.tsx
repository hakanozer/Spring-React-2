import React, { useState } from 'react'
import Navbar from '../components/Navbar'
import { useParams } from 'react-router-dom'

function Detail() {

  const params = useParams()
  console.log( params.id )
  console.log( params.index )
  const [id, setId] = useState(params.id)
  const [index, setIndex] = useState(params.index)

  return (
    <>
        <Navbar/>
        <h2>{id}</h2>
        <h2>{index}</h2>
        <div>Detail</div>
    </>
  )
}

export default Detail