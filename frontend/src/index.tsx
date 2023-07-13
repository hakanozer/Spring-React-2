import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom'

// import pages
import Home from './pages/Home';
import Category from './pages/Category';
import Detail from './pages/Detail';

const router = 
<BrowserRouter>
  <Routes>
    <Route path='/' element={<Home/>}/>
    <Route path='/category' element={<Category/>}/>
    <Route path='/detail/:id/:index' element={<Detail />} />
  </Routes>
</BrowserRouter>


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(router);

