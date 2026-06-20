import React from "react";

function Navbar() {
  return (
    <nav className="bg-blue-600 text-white p-4 flex justify-between">
      <h1 className="text-xl font-bold">My App</h1>

      <ul className="flex gap-6">
        <li><a href="/">Home</a></li>
        <li><a href="/">About</a></li>
        <li><a href="/">Contact</a></li>
      </ul>
    </nav>
  );
}

export default Navbar;