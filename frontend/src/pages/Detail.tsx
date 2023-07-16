import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { singleProduct } from '../service'
import { Product } from '../models/DummProducts'

function Detail() {

   const navigate = useNavigate()
   const params = useParams()
   const id = params.id

   const [item, setItem] = useState<Product>()
   useEffect(() => {
    if (id) {
        singleProduct(id).then( res => {
            setItem(res.data)
        }).catch(err => {
            //alert(err.message)
            navigate('/home')
        })
    }
   }, [])
   

  return (
    <>
        { item && 
            <>
                <h2>{item.title}</h2>
            </>
        }
    </>
  )
}

export default Detail