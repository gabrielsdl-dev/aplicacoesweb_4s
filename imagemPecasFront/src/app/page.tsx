
'use client';

import { useState } from 'react';

export default function GaleriaPage() {
  const [contador, setContador] = useState(0);

  return (
    <div className="p-10">
      <h1>Teste do botão</h1>

      <p>Cliques: {contador}</p>

      <button
        type="button"
        onClick={() => {
          console.log('CLIQUE FUNCIONOU!');
          setContador(contador + 1);
        }}
        className="bg-blue-500 text-white p-3"
      >
        Testar clique
      </button>
    </div>
  );
}
