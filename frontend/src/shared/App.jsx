import { Route, Routes } from 'react-router-dom';
import { About, Home, Main } from '../pages';
import { Footer, Navbar } from '../components';

export default function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<Main />} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
      <Footer />
    </>
  );
}
