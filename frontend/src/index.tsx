import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom'

// import pages
import Home from './pages/Home';
import Login from './pages/Login';
import Control from './pages/Control';
import Detail from './pages/Detail';

const router = 
<BrowserRouter>
  <Routes>
    <Route path='/' element={<Login />} />
    <Route path='/home' element={ <Control item={<Home/>} /> }/>
    <Route path='/detail/:id' element={ <Control item={<Detail/>} /> }/>
  </Routes>
</BrowserRouter>


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(router);

