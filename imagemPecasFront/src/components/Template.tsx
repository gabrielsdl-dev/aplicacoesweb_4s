interface TemplateProps {
    children: React.ReactNode
}

export const Template: React.FC<TemplateProps> = (props: TemplateProps) => {
    return(
        <>
                <Header/>
                {props.children}

                // footer
        </>
    )
}

const Header: React.FC = () => {
  return(
    <header>
      <div className="container mx-auto flex items-center justify-between px-4">
        <h1 className="text-3x1 font-bold">Imagem Peças</h1>
      </div>
    </header>
  )
}