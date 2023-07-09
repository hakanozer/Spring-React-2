import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom'

// import pages
import Home from './pages/Home';
import Category from './pages/Category';

const router = 
<BrowserRouter>
  <Routes>
    <Route path='/' element={<Home/>}/>
    <Route path='/category' element={<Category/>}/>
  </Routes>
</BrowserRouter>


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(router);

