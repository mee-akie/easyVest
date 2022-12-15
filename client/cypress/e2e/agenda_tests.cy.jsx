describe('Assert agenda', () => {

    beforeEach(() => {
      cy.visit('http://localhost:3000/calendar')
    })

    it('Agenda not clicked', () => {
      cy.get('.modal_default_main').should('not.exist')
    })
  
    it('Popup test after the agenda was clicked', () => {
      cy.get('.calendar_default_main').click()
      cy.get('.modal_default_main').should('exist')
    })
  
  })