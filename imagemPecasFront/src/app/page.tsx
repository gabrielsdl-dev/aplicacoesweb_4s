'use client'

import { Template, ImageCard } from '@/components';
import { useState } from 'react';



export default function GaleriaPage() {

  const image1 = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT2m6fnHAy2KrLpqVDjBvDV8_rsqiH0EALZB0uVy7uAg&s=10'
  const image2 = 'https://lncimg.lance.com.br/cdn-cgi/image/width=950,quality=60,fit=pad,format=webp/uploads/2026/10/Corinthians-1-e1788441351204-aspect-ratio-512-320.jpg'
  
  const nome1 = 'Imagem 1' 
  const nome2 = 'Imagem 2'


  const [codigoImage, setCodigoImage] = useState<number>(2);
  const [urlImage, setUrlImage] = useState<string>(image2);

  const [nomeImage, setNomeImage] = useState<string>(nome2);

  function mudarImagem(){

    console.log('Botão clicado!');
    if(codigoImage == 1){
      setCodigoImage(2);
      setUrlImage(image2);
      setNomeImage(nome2)
    }else{
      setCodigoImage(1);
      setUrlImage(image1);
      setNomeImage(nome1)
    }
  }





  return (
    <Template>
      <button className='bg-gray-500' onClick={mudarImagem}>Clique para Mudar</button>
      <section className="grid grid-cols-3 gap-8">
        <ImageCard nome={nomeImage} tamanho='10MB' dataUpload='10/02/2007' src={urlImage}/>
        <ImageCard nome={nomeImage} tamanho='10MB' dataUpload='10/02/2007' src={urlImage}/>
        <ImageCard nome={nomeImage} tamanho='10MB' dataUpload='10/02/2007' src={urlImage}/>
      </section>
    </Template>
  );
}
