import React from 'react'
import ReactDOM from 'react-dom/client'
// import './index.css'
import { ProductApp } from './components/ProductApp'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <ProductApp title={'Lista de Productos!'}/>
  </React.StrictMode>,
)
