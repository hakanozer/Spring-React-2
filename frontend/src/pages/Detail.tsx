import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { addCard, singleProduct } from '../service'
import { Product } from '../models/DummProducts'
import { IAdmin } from '../models/IAdmin'
import { toast } from 'react-toastify';
import { decrypt } from '../util'

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

   const [adm, setAdm] = useState<IAdmin>()
   useEffect(() => {
    const stSession = sessionStorage.getItem('admin')
    var admin:IAdmin
    if ( stSession !== null ) {
      try {
        const plainText = decrypt(stSession)
        admin = JSON.parse(plainText) as IAdmin
        if (admin) {
            setAdm(admin)
        }else {
            navigate('/')
        }
        
      } catch (error) {
        //sessionStorage.removeItem('admin')
        navigate('/')
        console.log("oturm yok")
      }

    }
   }, [])
   


   const addBasket = () => {
    addCard(adm!.id, id!).then(res => {
        const obj = res.data
        if (obj) {
            toast.success("Add Basket Success!")
        }
        console.log( obj )
    }).catch(err => {
        console.log(err.message)
    })
    addLocal(id!)
   }
   
   const addLocal = (id: string) => {
    const stObj = localStorage.getItem('basket')
    if ( stObj ) {
        // daha önce eklenmiş
        var stArr:string[] = []
        stArr = JSON.parse(stObj) as string[]
        stArr.push(id)
        const st = JSON.stringify(stArr)
        localStorage.setItem("basket", st) 

    }else {
        const arr:string[] = []
        arr.push(id)
        const saveStr = JSON.stringify(arr)
        localStorage.setItem("basket", saveStr) 
    }
   }

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
                        <button onClick={addBasket} className='btn btn-danger'>Add Basket</button>
                    </div>
                    <div className='col-sm-6'>
                    <img src={bigImage} className="img-fluid img-thumbnail"  />
                    <div className='row mt-3'>
                        { item.images.map((item, index) => 
                            <div key={index} className='col-2' role='button' onClick={() => setBigImage(item) }>
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