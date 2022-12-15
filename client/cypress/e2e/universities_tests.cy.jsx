describe('Assert universities data', () => {

  beforeEach(() => {
    cy.visit('http://localhost:3000/universities')
  })

  it('ENEM test', () => {
    cy.get('.uni-menu-item').contains('ENEM').click()
    cy.get('h2').last().should('have.text', 'ENEM')
  })

  it('UFABC test', () => {
    cy.get('.uni-menu-item').contains('UFABC').click()
    cy.get('h2').last().should('have.text', 'UFABC')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campusCursos disponíveis nos campusMétodos de Avaliação')
  })

  it('USP test', () => {
    cy.get('.uni-menu-item').contains('USP').click()
    cy.get('h2').last().should('have.text', 'USP')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campusCursos disponíveis nos campusMétodos de avaliação:Obras literárias')
  })

  it('UFSCAR test', () => {
    cy.get('.uni-menu-item').contains('UFSCAR').click()
    cy.get('h2').last().should('have.text', 'UFSCAR')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campusCursos disponíveis nos campusMétodos de avaliação')
  })

  it('UNICAMP test', () => {
    cy.get('.uni-menu-item').contains('UNICAMP').click()
    cy.get('h2').last().should('have.text', 'UNICAMP')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campusCursos disponíveis nos campusMétodos de avaliaçãoObras literárias')
  })

  it('UNESP test', () => {
    cy.get('.uni-menu-item').contains('UNESP').click()
    cy.get('h2').last().should('have.text', 'UNESP')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campusCursos disponíveis nos campusMétodos de avaliação')
  })

  it('UNIFESP test', () => {
    cy.get('.uni-menu-item').contains('UNIFESP').click()
    cy.get('h2').last().should('have.text', 'UNIFESP')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campusCursos disponíveis nos campusMétodos de avaliação')
  })

  it('ITA test', () => {
    cy.get('.uni-menu-item').contains('ITA').click()
    cy.get('h2').last().should('have.text', 'ITA')
    cy.get('h3').should('have.text', 'Geral da universidadeLocais dos campus:Cursos disponíveis nos campus:Métodos de avaliaçãoObras literárias:')
  })

})