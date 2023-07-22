import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

// import pages
import Home from './pages/Home';
import Login from './pages/Login';
import Control from './pages/Control';
import Detail from './pages/Detail';
import Basket from './pages/Basket';

const router = 
<BrowserRouter>
  <ToastContainer/>
  <Routes>
    <Route path='/' element={<Login />} />
    <Route path='/home' element={ <Control item={<Home/>} /> }/>
    <Route path='/detail/:id' element={ <Control item={<Detail/>} /> }/>
    <Route path='/basket' element={ <Control item={<Basket/>} /> }/>
  </Routes>
</BrowserRouter>


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(router);

