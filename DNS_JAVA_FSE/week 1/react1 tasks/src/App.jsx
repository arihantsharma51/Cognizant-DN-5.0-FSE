import React from 'react'
import Navbar from "./Navbar"
import main from "./main"
import Footer from './Footer'



function App() {
  return (
    <>
    <Navbar/>
    <div className="bg-black h-screen flex items-center justify-center">
      <h1 className="text-5xl text-white font-bold">
        Tailwind Working hello
      </h1>
    </div>
    <Footer/>
    </>
    
  )
}

export default App
