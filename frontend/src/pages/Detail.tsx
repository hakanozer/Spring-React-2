import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { singleProduct } from '../service'
import { Product } from '../models/DummProducts'

function Detail() {

   const navigate = useNavigate()
   const params = useParams()
   const id = params.id

   const [item, setItem] = useState<Product>()
   const [bigImage, setBigImage] = useState('')
   useEffect(() => {
    if (id) {
        singleProduct(id).then( res => {
            setItem(res.data)
            setBigImage(res.data.images[0])
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
                <div className='row'>
                    <div className='col-sm-6'>
                        <h2>{item.title}</h2>
                        <p>{item.description}</p>
                        <p>{item.price}$</p>
                        <p>{item.brand}</p>
                        <p>{item.stock}</p>
                    </div>
                    <div className='col-sm-6'>
                    <img src={bigImage} className="img-fluid img-thumbnail"  />
                    <div className='row mt-3'>
                        { item.images.map((item, index) => 
                            <div className='col-2' role='button' onClick={() => setBigImage(item) }>
                                <img src={item} className='img-thumbnail' />
                            </div>
                        )}
                    </div>
                    </div>
                </div>
            </>
        }
    </>
  )
}

export default Detail