import { PastwiskoPage } from './app.po';

describe('pastwisko App', () => {
  let page: PastwiskoPage;

  beforeEach(() => {
    page = new PastwiskoPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
